<template>
    <barra-navegacao></barra-navegacao>
  
    <div class="container mt-4">
      <h1>Editar Aluno</h1>
      <form @submit.prevent="atualizarAluno">
        <div class="mb-3">
          <label for="nome" class="form-label">Nome</label>
          <input v-model="aluno.nome" type="text" id="nome" class="form-control" required />
        </div>
        <div class="mb-3">
          <label for="email" class="form-label">Email</label>
          <input v-model="aluno.email" type="email" id="email" class="form-control" required />
        </div>
        <div class="mb-3">
          <label for="curso" class="form-label">Curso</label>
          <input v-model="aluno.curso" type="text" id="curso" class="form-control" required />
        </div>
        <button type="submit" class="btn btn-primary">Salvar</button>
      </form>
    </div>
  </template>
  
  <script>
  import BarraNavegacao from "@/components/BarraNavegacao.vue";
  import axios from "axios";
  
  export default {
    components: { BarraNavegacao },
    data() {
      return {
        aluno: {
          nome: "",
          email: "",
          curso: "",
        },
      };
    },
    mounted() {
      this.getAluno();
    },
    methods: {
      async getAluno() {
        try {
          const response = await axios.get(`http://localhost:8080/alunos/${this.$route.params.id}`);
          this.aluno = response.data;
        } catch (error) {
          console.error("Erro ao buscar aluno:", error);
        }
      },
      async atualizarAluno() {
        try {
          await axios.put(`http://localhost:8080/alunos/${this.$route.params.id}`, this.aluno);
          alert("Aluno atualizado com sucesso!");
          this.$router.push("/alunos");
        } catch (error) {
          console.error("Erro ao atualizar aluno:", error);
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
  