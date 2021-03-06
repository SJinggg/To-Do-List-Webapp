<template>
  <div class="to-do-container">
    <create-to-do @create="create" />
    <div class="to-do-list-container">
      <to-do-list-item v-for="todo in todos" :key="todo.id" :todo="todo" />
    </div>
  </div>
</template>

<script>
import ToDoListItem from '~/components/todoitem.vue';
import CreateToDo from '~/components/createtodo.vue';
import Createtodo from './createtodo.vue';
export default {
  components: {
    ToDoListItem,
    CreateToDo
  },
  props: {
    todos: Array
  },
  methods: {
    create (item) {
      console.log(item)
      this.todos.push(item);
    },
    delete (item) {
      this.todos.splice(this.todos.indexOf(item), 1)
    }
  }
}
</script>

<style lang="scss">
.to-do-container {
  width: 400px;
  margin: auto;
  margin-top: 50px;
  display: block;

  .create-container {
    width: 100%;
    height: 50px;
    box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);

    input {
      margin: 0;
      width: 250px;
      height: 100%;
      border: none;
      padding-left: 10px;
      font-family: "Quicksand", "Source Sans Pro", -apple-system,
        BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial,
        sans-serif;
      font-size: 18px;
      &:focus {
        outline: none;
      }
    }

    button {
      height: 45px;
      float: right;
      background: none;
      width: auto;
      margin: 0;
      border: none;
      cursor: pointer;
      text-align: right;
      padding-right: 20px;
      font-size: 18px;
      &:focus {
        outline: none;
      }
    }
  }
}
.to-do-list-container {
  width: 400px;
  margin: auto;
  margin-top: 50px;
  display: block;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
}
</style>