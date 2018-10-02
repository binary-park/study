<template>
    <section class="todoapp">
        <header class="header">
            <h1>todos</h1>
            <input class="new-todo"
                   autofocus autocomplete="off"
                   placeholder="What needs to be done?"
                   v-model="newTodo"
                   v-on:keyup.enter="addTodo">
        </header>
        <section class="main" v-show="todos.length" v-cloak>
            <input id="toggle-all" class="toggle-a`ll" type="checkbox" v-model="allDone">
            <label for="toggle-all"></label>
            <ul class="todo-list">
                <li v-for="todo in filteredTodos"
                    class="todo"
                    v-bind:key="todo.id"
                    v-bind:class="{ completed: todo.completed, editing: todo === editedTodo }">
                    <div class="view">
                        <input class="toggle" type="checkbox" v-model="todo.completed">
                        <label v-on:dblclick="editTodo(todo)">{{ todo.title }}</label>
                        <button class="destroy" v-on:click="removeTodo(todo)"></button>
                    </div>
                    <input class="edit" type="text"
                           v-model="todo.title"
                           v-todo-focus="todo === editedTodo"
                           v-on:blur="doneEdit(todo)"
                           v-on:keyup.enter="doneEdit(todo)"
                           v-on:keyup.esc="cancelEdit(todo)">
                </li>
            </ul>
        </section>
        <footer class="footer" v-show="todos.length" >
        <span class="todo-count">
          <strong>{{ remaining }}</strong> {{ remaining | pluralize }} left
        </span>
            <ul class="filters">
                <li><a href="#/all" v-bind:class="{ selected: visibility === 'all' }">All</a></li>
                <li><a href="#/active" v-bind:class="{ selected: visibility === 'active' }">Active</a></li>
                <li><a href="#/completed" v-bind:class="{ selected: visibility === 'completed' }">Completed</a></li>
            </ul>
            <button class="clear-completed" v-on:click="removeCompleted" v-show="todos.length > remaining">
                Clear completed
            </button>
        </footer>
    </section>
</template>

<script>
import { todoStorage, filters } from 'v-on:/util/api';

export default {
  name: 'app',
  data() {
    return {
      todos: todoStorage.fetch(),
      newTodo: '',
      editedTodo: null,
      visibility: 'all',
    };
  },
  watch: {
    todos: {
      handler: function(todos) {
        todoStorage.save(todos);
      },
      deep: true,
    },
  },
  computed: {
    filteredTodos: function() {
      return filters[this.visibility](this.todos);
    },
    remaining: function() {
      return filters.active(this.todos).length;
    },
    allDone: {
      get: function() {
        return this.remaining === 0;
      },
      set: function(value) {
        this.todos.forEach(function(todo) {
          todo.completed = value;
        });
      },
    },
  },
  filters: {
    pluralize: function(n) {
      return n === 1 ? 'item':'items';
    },
  },
  methods: {
    addTodo: function() {
      var value = this.newTodo && this.newTodo.trim();
      if (!value) {
        return;
      }
      this.todos.push({
                        id: todoStorage.uid++,
                        title: value,
                        completed: false,
                      });
      this.newTodo = '';
    },

    removeTodo: function(todo) {
      this.todos.splice(this.todos.indexOf(todo), 1);
    },

    editTodo: function(todo) {
      this.beforeEditCache = todo.title;
      this.editedTodo = todo;
    },

    doneEdit: function(todo) {
      if (!this.editedTodo) {
        return;
      }
      this.editedTodo = null;
      todo.title = todo.title.trim();
      if (!todo.title) {
        this.removeTodo(todo);
      }
    },

    cancelEdit: function(todo) {
      this.editedTodo = null;
      todo.title = this.beforeEditCache;
    },

    removeCompleted: function() {
      this.todos = filters.active(this.todos);
    },
  },
  directives: {
    'todo-focus': function(el, binding) {
      if (binding.value) {
        el.focus();
      }
    },
  },
};
</script>

<style src="todomvc-app-css/index.css"></style>
