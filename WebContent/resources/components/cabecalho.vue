<template>
<div>
    <v-app-bar
      color="#273c75"
      dense
      dark
    >
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
    
      <v-toolbar-title>Comparação de Arquivos</v-toolbar-title> 
      <v-spacer></v-spacer>
      <div>
      <span class="mr-8"> 
        <i class="fab fa-github ml-4">
        </i> 
        <a href="https://github.com/gbrsantos" target="_blank" class="link-github">gbrsantos</a>        
      </span>
      </div>      
    </v-app-bar>
  </div>
</template>
<script>
module.exports = {
  name: "cabecalho",
  components: {},

  data() {
    return {
          
    };
  },
  methods: {   
  }
};
</script>
<style href="../fontawesome/css/all.css"></style>
<style>
.link-github{
    text-decoration:none;
    color: white !important;
}
.link-github:hover{
    text-decoration:underline;
    font-weight:bold;
}
</style>
