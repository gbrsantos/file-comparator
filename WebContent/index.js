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
        form:{
          arquivo1:null,
          arquivo2:null,
        }
    };
  },
  methods:{
    
  },
  mouted() {},
});