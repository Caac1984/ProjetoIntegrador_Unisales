<template>
  <barra-navegacao></barra-navegacao>

  <div class="lista">
    <div class="row g-0 justify-content-center">
      <div class="col-lg-9 col-md-6 col-sm-8">
        <div class="card">
          <h1>Lista de Grupos</h1>
          <table class="table table-striped table-primary">
            <thead class="table-dark">
              <tr>
                <th>Nome do Grupo</th>
                <th>Descrição</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(grupo, index) in grupos" :key="index">
                <td>{{ grupo.nome }}</td>
                <td>{{ grupo.descricao }}</td>
                <td>
                  <button
                    class="btn btn-primary me-2"
                    @click="editarGrupo(grupo.id)"
                  >
                    Editar
                  </button>
                  <button
                    class="btn btn-danger"
                    @click="excluirGrupo(grupo.id)"
                  >
                    Excluir
                  </button>
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
import AuthService from "@/services/AuthService";
import axios from "axios";

export default {
  components: {
    BarraNavegacao,
  },
  data() {
    return {
      grupos: [],
    };
  },
  async mounted() {
    this.getGrupos();
  },
  methods: {
    async getGrupos() {
      try {
        const response = await axios.get("http://localhost:8080/grupos", {
          headers: { Authorization: `Bearer ${AuthService.dados.token}` },
        });
        this.grupos = response.data;
      } catch (error) {
        console.log("Erro ao buscar grupos:", error);
      }
    },
    editarGrupo(id) {
      this.$router.push(`/grupos/editar/${id}`);
    },
    async excluirGrupo(id) {
      try {
        const response = await axios.delete(
          `http://localhost:8080/grupos/${id}`,
          {
            headers: { Authorization: `Bearer ${AuthService.dados.token}` },
          }
        );
        if (response.status === 200) {
          this.getGrupos();
        }
      } catch (error) {
        console.log("Erro ao excluir grupo:", error);
      }
    },
  },
};
</script>
