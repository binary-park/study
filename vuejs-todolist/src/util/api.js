const STORAGE_KEY = 'todos-vuejs-2.0';
const todoStorage = {
  fetch() {
    var todos = JSON.parse(localStorage.getItem(STORAGE_KEY) || '[]');
    todos.forEach(function(todo, index) {
      todo.id = index;
    });
    todoStorage.uid = todos.length;
    return todos;
  },
  save(todos) {
    localStorage.setItem(STORAGE_KEY, JSON.stringify(todos));
  },
};

const filters = {
  all(todos) {
    return todos;
  },
  active(todos) {
    return todos.filter(function(todo) {
      return !todo.completed;
    });
  },
  completed(todos) {
    return todos.filter(function(todo) {
      return todo.completed;
    });
  },
};

export { todoStorage, filters };
