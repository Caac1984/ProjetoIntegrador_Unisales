<template>
    <div>
      <barra-navegacao></barra-navegacao> <!-- Barra de navegação -->
      <div class="row g-0 justify-content-center">
        <div class="col-lg-6">
          <div class="card">
        <h1>Cadastro de Quesitos</h1>
        <form @submit.prevent="salvarQuesito">
          <!-- Nome do Quesito -->
          <div class="mb-3">
            <label for="nome" class="form-label">Nome do Quesito</label>
            <input v-model="quesito.nome" type="text" id="nome" class="form-control" placeholder="Digite o nome do quesito" required />
          </div>
  
          <!-- Descrição do Quesito -->
          <div class="mb-3">
            <label for="descricao" class="form-label">Descrição</label>
            <textarea v-model="quesito.descricao" id="descricao" class="form-control" placeholder="Digite a descrição do quesito" required></textarea>
          </div>
  
          <!-- Botão para salvar -->
          <div class="d-grid gap-2 d-md-block">
            <button type="submit" class="btn btn-primary">Salvar Quesito</button>
          </div>
        </form>
      </div>
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
        quesito: {
          nome: "",
          descricao: "",
        },
      };
    },
    methods: {
      // Método para salvar o quesito
      async salvarQuesito() {
        try {
          const response = await axios.post("http://localhost:8080/quesitos", this.quesito);
          if (response.status === 201) {
            alert("Quesito cadastrado com sucesso!");
            this.$router.push("/quesitos"); // Redireciona para a lista de quesitos após cadastro
          }
        } catch (error) {
          console.error("Erro ao salvar quesito:", error);
        }
      },
    },
  };
  </script>
  
  <style scoped>
  /* Estilos específicos para a página de cadastro de quesitos */
  .container {
    max-width: 600px;
    margin-top: 20px;
  }
  
  .mb-3 {
    margin-bottom: 1rem;
  }
  
  textarea {
    height: 100px;
  }
  </style>
  