<template>
  <div class="container">
    <h1 class="title">
      My To Do List
    </h1>
    <todolist :todos="todos" />
  </div>
</template>

<script>
import ToDoList from '~/components/todolist.vue'
export default {
  components: {
    ToDoList
  },
  data () {
    return {
      todos: []
    }
  },
  async asyncData (ctx) {
    return {
      todos: await ctx.app.$services.todo.findAll()
    }
  }
}
</script>