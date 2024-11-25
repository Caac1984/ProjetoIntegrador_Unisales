import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import NaoAutorizadoView from '../views/NaoAutorizadoView.vue'
import UsuariosView from '../views/usuarios/UsuariosView.vue'
import UsuarioEditView from '../views/usuarios/UsuarioEditView.vue'
import ProjetosView from '../views/projetos/ProjetosView.vue'
import ProjetosEditView from '../views/projetos/ProjetosEditView.vue'
import CadastroAluno from '../views/alunos/CadastroAluno.vue';
import EditarAluno from '../views/alunos/EditarAluno.vue';
import ListaAlunos from '../views/alunos/ListaAlunos.vue';
import CadastroProfessor from '../views/professores/CadastroProfessor.vue';
import EditarProfessor from '../views/professores/EditarProfessor.vue';
import ListaProfessores from '../views/professores/ListaProfessores.vue';
import CadastroVisitante from '../views/visitantes/CadastroVisitante.vue';
import EditarVisitante from '../views/visitantes/EditarVisitante.vue';
import ListaVisitantes from '../views/visitantes/ListaVisitantes.vue';
import CadastroGrupo from '../views/grupos/CadastroGrupo.vue';
import EditarGrupo from '../views/grupos/EditarGrupo.vue';
import ListaGrupos from '../views/grupos/ListaGrupos.vue';
import CadastroCurso from '../views/cursos/CadastroCurso.vue';
import EditarCurso from '../views/cursos/EditarCurso.vue';
import ListaCursos from '../views/cursos/ListaCursos.vue';
import AvaliacaoView from '@/views/AvaliacaoView.vue'

import LoginService from '../services/LoginService'
import AuthService from '@/services/AuthService'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/projetos',
    name: 'projetos',
    component: ProjetosView
  },
  {
    path: '/projetos/:id',
    name: 'projetosedit',
    component: ProjetosEditView
  },
  {
    path: '/usuarios',
    name: 'usuarios',
    component: UsuariosView
  },
  {
    path: '/usuarios/:id',
    name: 'usuariosedit',
    component: UsuarioEditView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/nao-autorizado',
    name: 'nao-autorizado',
    component: NaoAutorizadoView
  },
  {
    path: '/sobre',
    name: 'sobre',
    component: () => import('../views/AboutView.vue') // Importação dinâmica para melhor desempenho
  },
  {
    path: '/alunos',
    name: 'ListaAlunos',
    component: ListaAlunos
  },
  {
    path: '/alunos/cadastrar',
    name: 'CadastroAluno',
    component: CadastroAluno
  },
  {
    path: '/alunos/editar/:id',
    name: 'EditarAluno',
    component: EditarAluno
  },
  {
    path: '/professores',
    name: 'ListaProfessores',
    component: ListaProfessores
  },
  {
    path: '/professores/cadastrar',
    name: 'CadastroProfessor',
    component: CadastroProfessor
  },
  {
    path: '/professores/editar/:id',
    name: 'EditarProfessor',
    component: EditarProfessor
  },
  {
    path: '/visitantes',
    name: 'ListaVisitantes',
    component: ListaVisitantes
  },
  {
    path: '/visitantes/cadastrar',
    name: 'CadastroVisitante',
    component: CadastroVisitante
  },
  {
    path: '/visitantes/editar/:id',
    name: 'EditarVisitante',
    component: EditarVisitante
  },
  {
    path: '/grupos',
    name: 'ListaGrupos',
    component: ListaGrupos
  },
  {
    path: '/grupos/cadastrar',
    name: 'CadastroGrupo',
    component: CadastroGrupo
  },
  {
    path: '/grupos/editar/:id',
    name: 'EditarGrupo',
    component: EditarGrupo
  },
  {
    path: '/cursos',
    name: 'ListaCursos',
    component: ListaCursos
  },
  {
    path: '/cursos/cadastrar',
    name: 'CadastroCurso',
    component: CadastroCurso
  },
  {
    path: '/cursos/editar/:id',
    name: 'EditarCurso',
    component: EditarCurso
  },
  {
  path: '/avaliacao',
  name: 'avaliacao',
  component: AvaliacaoView
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

router.beforeEach((to, from) => {
  LoginService.router = router;

  // Debug para monitorar as navegações
  console.log(`de ${from.name} para ${to.name}`);

  // Verifica autenticação
  if (!LoginService.estaAutenticado() && to.name !== 'login') {
    return { name: 'login' } // Redireciona para a página de login se não estiver autenticado
  }

  // Verifica permissões
  if (!AuthService.validaPermissao(to.path)) {
    return { name: 'nao-autorizado' } // Redireciona para a página não autorizado se não tiver permissão
  }

  return true; // Permite a navegação se todas as verificações passarem
})

export default router
