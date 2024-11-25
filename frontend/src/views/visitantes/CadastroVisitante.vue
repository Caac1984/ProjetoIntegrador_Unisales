<template>
    <barra-navegacao></barra-navegacao>
  
    <div class="row g-0 justify-content-center">
        <div class="col-lg-6">
          <div class="card">
      <h1>Cadastro de Visitante</h1>
      <form @submit.prevent="salvarVisitante">
        <div class="row gx-3 gy-2 align-items-center p-2">
        <div class="col-sm-3">
          <input v-model="visitante.nome" placeholder="Nome" type="text" id="nome" class="form-control" required />
        </div> 
        <div class="col-sm-3">
          <input v-model="visitante.cpf" placeholder="CPF" type="text" id="cpf" class="form-control" />
        </div>
        </div>
        <div class="row gx-3 gy-2 align-items-center p-2">
        <div class="col-sm-3">
          <input v-model="visitante.email" placeholder="E-mail" type="email" id="email" class="form-control" required />
        </div>
        <div class="col-sm-3">
          <input v-model="visitante.telefone" placeholder="Telefone" type="text" id="telefone" class="form-control" />
        </div>
       
</div>
        <button type="submit" class="btn btn-primary">Salvar</button>
      </form>
    </div>
  </div>
</div>

  </template>
  
  <script>
  import BarraNavegacao from "@/components/BarraNavegacao.vue";
  import axios from "axios";
  
  export default {
    components: { BarraNavegacao },
    data() {
      return {
        visitante: {
          nome: "",
          cpf: "",
          email: "",
          telefone: "",
        },
      };
    },
    methods: {
      async salvarVisitante() {
        try {
          const response = await axios.post("http://localhost:8080/visitantes", this.visitante);
          if (response.status === 201) {
            alert("Visitante cadastrado com sucesso!");
            this.$router.push("/visitantes");
          }
        } catch (error) {
          console.error("Erro ao salvar visitante:", error);
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .container {
    max-width: 600px;
  }
  </style>
  