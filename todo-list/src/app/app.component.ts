import { Component, OnInit } from '@angular/core';

interface Todo {
  id: number;
  title: string;
  completed: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  todos: Todo[] = [];
  newTodoTitle: string = '';

  ngOnInit() {
    const savedTodos = localStorage.getItem('todos');
    if (savedTodos) {
      try {
        this.todos = JSON.parse(savedTodos);
      } catch (e) {
        console.error('Error parsing todos from localStorage', e);
      }
    }
  }

  addTodo() {
    if (this.newTodoTitle.trim()) {
      const newTodo: Todo = {
        id: Date.now(),
        title: this.newTodoTitle.trim(),
        completed: false
      };
      this.todos.push(newTodo);
      this.saveTodos();
      this.newTodoTitle = '';
    }
  }

  deleteTodo(id: number) {
    this.todos = this.todos.filter(todo => todo.id !== id);
    this.saveTodos();
  }

  toggleCompletion(todo: Todo) {
    todo.completed = !todo.completed;
    this.saveTodos();
  }

  saveTodos() {
    localStorage.setItem('todos', JSON.stringify(this.todos));
  }
}
