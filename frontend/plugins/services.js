import ToDoService from '~/assets/service/ToDoService'
import LoginService from '~/assets/service/LoginService'

export default (ctx, inject) => {
  const services = {
    todo: new ToDoService(ctx.$axios),
    login: new LoginService(ctx.$axios)
  }

  inject('services', services)
}