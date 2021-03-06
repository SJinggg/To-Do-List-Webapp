<template>
  <div class="to-do-item" :class="{ completed: todo.completed }">
    <span class="todo-title">{{ todo.title }}</span>
    <div class="controls">
      <span @click="deleteItem">🗑</span>
      <span @click="completeItem"><div v-if="!this.todo.completed">✓</div><div v-else>✗</div></span>
    </div>
  </div>
</template>

<script>

export default {
  props: {
    todo: Object
  },
  methods: {
    completeItem () {
      this.$services.todo.complete(this.todo).then((data) => {
        this.todo.completed = !this.todo.completed;
      })
    },
    deleteItem () {
      this.$services.todo.deleteItem(this.todo.id).then(() => {
        this.$parent.delete(this.todo)
      })
    }
  }
}
</script>

<style lang="scss">
.to-do-item {
  width: 100%;
  display: block;
  height: 50px;
  &.completed {
    opacity: 0.2;
    .todo-title {
      text-decoration: line-through;
    }
  }
  span {
    height: 50px;
    padding-left: 20px;
    line-height: 50px;
    width: 300px;
    display: inline-block;
  }
  .controls {
    display: inline-block;
    height: 50px;
    line-height: 50px;
    span {
      line-height: 50px;
      height: 50px;
      display: inline-block;
      width: 45px;
      text-align: center;
      padding: 0;
      cursor: pointer;
    }
  }
}
</style>