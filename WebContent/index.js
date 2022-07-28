const home = new Vue({
  el: '#home', //esse el tem que ser o id da div container do html
  vuetify: new Vuetify(),
  components: { 
     cabecalho : httpVueLoader('./resources/components/cabecalho.vue'),
  },
  data(){
    return{
        texto: "",
        variavelTeste:"alinhamento-div",
        validacao:false,
        arquivo1:null,
        arquivo2:null,        
        porcentagem:null,
        form:{},
        loader: false,
        aparecerPorcentagem:false,
        aparecerBotao: false,
    };
  },
  watch:{
    arquivo2(arquivo2){
      const vm = this; 
      if(vm.arquivo2 && vm.arquivo1 == null)
       vm.aparecerPorcentagem = false;     
      if(vm.arquivo1 && vm.arquivo2){
        vm.aparecerBotao = true;        
      }
    },
    arquivo1(arquivo1){
      const vm =this      
     if(vm.arquivo1 && vm.arquivo2 == null)
       vm.aparecerPorcentagem = false;
     if(vm.arquivo1 && vm.arquivo2){
        vm.aparecerBotao = true;       
      }
    },    
  },
  methods:{
    verificarPorcentagem(){
      const vm = this;
      if(vm.arquivo1 == null ){
        alert("Coloque o primeiro pdf");
        return;
      }
      if(vm.arquivo2 == null ){
        alert("Coloque o segundo pdf");
        return;
      }        
      vm.loader = true;
      vm.aparecerBotao=false;
      vm.aparecerPorcentagem = false;    
      const formData = new FormData();      
      formData.append("file1",vm.arquivo1)
      formData.append("file2",vm.arquivo2)
      axios.post('http://localhost:8080/file-comparator/rest/comparacao-arquivo', formData)
      .then(response =>{
        vm.porcentagem = 100 - response.data; 
        vm.aparecerPorcentagem = true;       
      }).catch(error=>{
        alert(error);
      }).finally(()=>{
        vm.arquivo1 = null;
        vm.arquivo2 = null;
        vm.loader = false;        
      })
    },
    limparFile(arquivo){
      const vm = this;
      switch(arquivo){
        case 'arquivo1':
          vm.arquivo1 = null;
          break;
        case 'arquivo2':
          vm.arquivo2 = null;
          break;
        default:
          alert("não foi possível limpar o arquivo");  
      }
    }
    
  },
  mounted() {
    const vm = this;    
  },
});