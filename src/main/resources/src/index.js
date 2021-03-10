import App from './App'
import 'normalize.css'
import './sass/main.sass'

const app = new App('Hello, world!')
console.log(`This is App ${app.toString()}`)