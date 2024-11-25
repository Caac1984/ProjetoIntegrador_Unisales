<template>
    <barra-navegacao></barra-navegacao>
  
    <div class="row g-0 justify-content-center">
      <div class="col-lg-6">
        <div class="card">
      
      <h1>Cadastro de Professor</h1>
      <form @submit.prevent="salvarProfessor">
         <div class="row gx-3 gy-2 align-items-center p-2">
        <div class="col-sm-3">
          <input v-model="professor.nome" type="text" id="nome"   placeholder="Nome" class="form-control" required />
        </div>
        <div class="col-sm-3">
          <input v-model="professor.matricula" placeholder="Matricula" type="text" id="matricula" class="form-control" required />
        </div>
         </div>
         <div class="row gx-3 gy-2 align-items-center p-2">
        <div class="col-sm-3">
          <input v-model="professor.email" placeholder="E-mail" type="email" id="email" class="form-control" required />
        </div>
        <div class="col-sm-3">
          <input v-model="professor.telefone" placeholder="Telefone" type="telefone" id="telefone" class="form-control" required />
        </div>
         </div>
         <div class="row gx-3 gy-2 align-items-center p-2">
        <div class="col-sm-3">
          <input v-model="professor.disciplina" placeholder="Disciplina" type="text" id="disciplina" class="form-control" required />
        </div>
        </div>
        <div class="d-grid gap-2 d-md-block bots">
        <button type="submit" class="btn btn-primary">Salvar</button>
      </div>
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
        professor: {
          nome: "",
          matricula: "",
          email: "",
          telefone: "",
          disciplina: "",
        },
      };
    },
    methods: {
      async salvarProfessor() {
        try {
          const response = await axios.post("http://localhost:8080/professores", this.professor);
          if (response.status === 201) {
            alert("Professor cadastrado com sucesso!");
            this.$router.push("/professores");
          }
        } catch (error) {
          console.error("Erro ao salvar professor:", error);
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
  