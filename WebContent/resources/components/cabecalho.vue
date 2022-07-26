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
      <span class="mr-8"><a class="link-github">gbrsantos</a></span>
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
