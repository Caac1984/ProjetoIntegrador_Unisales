<template>
  <div>
    <barra-navegacao></barra-navegacao> <!-- Barra de navegação -->
    
    <div class="row g-0 justify-content-center">
      <div class="col-lg-6">
        <div class="card">
      <h1>Avaliações de Trabalhos</h1>

      <!-- Formulário de Avaliação -->
      
        <div class="card-body">
          <h4>Cadastrar Avaliação</h4>
          <form @submit.prevent="salvarAvaliacao">
            <!-- Trabalho -->
            <div class="row gx-3 gy-2 align-items-center p-2">
            <div class="col-sm-3">
              <input
                v-model="avaliacao.trabalho"
                type="text"
                id="trabalho"
                class="form-control"
                placeholder="Nome do trabalho"
                required
              />
            </div>

            <!-- Nota -->
            <div class="col-sm-3">
              <input
                v-model="avaliacao.nota"
                type="number"
                id="nota"
                class="form-control"
                placeholder="Nota (0 a 10)"
                min="0"
                max="10"
                required
              />
            </div>
          </div>

            <!-- Comentários -->
            <div class="mb-3">
              <textarea
                v-model="avaliacao.comentarios"
                id="comentarios"
                class="form-control"
                rows="4"
                placeholder="Comentários sobre o trabalho"
                required
              ></textarea>
            </div>

            <!-- Botão de Submissão -->
            <button type="submit" class="btn btn-primary">Salvar Avaliação</button>
          </form>
        </div>
   

      <!-- Tabela de Avaliações -->
      <h4 class="mt-4">Avaliações Realizadas</h4>
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">Nome do Trabalho</th>
            <th scope="col">Nota</th>
            <th scope="col">Comentários</th>
            <th scope="col">Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="avaliacao in avaliacoes" :key="avaliacao.id">
            <td>{{ avaliacao.trabalho }}</td>
            <td>{{ avaliacao.nota }}</td>
            <td>{{ avaliacao.comentarios }}</td>
            <td>
              <button @click="excluirAvaliacao(avaliacao.id)" class="btn btn-danger">Excluir</button>
            </td>
          </tr>
        </tbody>
      </table>
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
      avaliacao: {
        trabalho: "",
        nota: "",
        comentarios: "",
      },
      avaliacoes: [], // Lista de avaliações
    };
  },
  created() {
    this.buscarAvaliacoes();
  },
  methods: {
    // Salva a avaliação
    async salvarAvaliacao() {
      try {
        const response = await axios.post("http://localhost:8080/avaliacoes", this.avaliacao);
        if (response.status === 201) {
          alert("Avaliação salva com sucesso!");
          this.buscarAvaliacoes(); // Atualiza a lista de avaliações
          this.avaliacao = {}; // Limpa o formulário
        }
      } catch (error) {
        console.error("Erro ao salvar avaliação:", error);
      }
    },

    // Busca as avaliações já cadastradas
    async buscarAvaliacoes() {
      try {
        const response = await axios.get("http://localhost:8080/avaliacoes");
        this.avaliacoes = response.data;
      } catch (error) {
        console.error("Erro ao buscar avaliações:", error);
      }
    },

    // Exclui uma avaliação
    async excluirAvaliacao(id) {
      try {
        const response = await axios.delete(`http://localhost:8080/avaliacoes/${id}`);
        if (response.status === 204) {
          alert("Avaliação excluída com sucesso!");
          this.buscarAvaliacoes(); // Atualiza a lista de avaliações
        }
      } catch (error) {
        console.error("Erro ao excluir avaliação:", error);
      }
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 800px;
}

.card {
  margin-bottom: 30px;
}

.table th,
.table td {
  vertical-align: middle;
}

table {
  margin-top: 20px;
}
</style>
