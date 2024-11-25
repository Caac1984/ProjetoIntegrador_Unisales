<template>
  <barra-navegacao></barra-navegacao>

  <div class="editar">
    <div class="row g-0 justify-content-center">
      <div class="col-lg-9 col-md-6 col-sm-8">
        <div class="card">
          <h1>Editar Grupo</h1>
          <form @submit.prevent="editarGrupo">
            <div class="row gx-3 gy-2 align-items-center p-2">
              <div class="col-sm-4">
                <input
                  v-model="grupo.nome"
                  type="text"
                  class="form-control"
                  placeholder="Nome do Grupo"
                  required
                />
              </div>
              <div class="col-sm-4">
                <input
                  v-model="grupo.descricao"
                  type="text"
                  class="form-control"
                  placeholder="Descrição"
                  required
                />
              </div>
            </div>
            <div class="row gx-3 gy-2 col-sm-0 align-items-center p-3">
              <button type="submit" class="btn btn-primary">Atualizar</button>
            </div>
          </form>
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
      grupo: {
        id: "",
        nome: "",
        descricao: "",
      },
    };
  },
  async mounted() {
    const grupoId = this.$route.params.id;
    this.getGrupo(grupoId);
  },
  methods: {
    async getGrupo(id) {
      try {
        const response = await axios.get(`http://localhost:8080/grupos/${id}`, {
          headers: { Authorization: `Bearer ${AuthService.dados.token}` },
        });
        this.grupo = response.data;
      } catch (error) {
        console.log("Erro ao buscar grupo:", error);
      }
    },
    async editarGrupo() {
      try {
        const response = await axios.put(
          `http://localhost:8080/grupos/${this.grupo.id}`,
          this.grupo,
          {
            headers: {
              Authorization: `Bearer ${AuthService.dados.token}`,
              "Content-Type": "application/json",
            },
          }
        );
        if (response.status === 200) {
          alert("Grupo atualizado com sucesso!");
        }
      } catch (error) {
        console.log("Erro ao atualizar grupo:", error);
      }
    },
  },
};
</script>
