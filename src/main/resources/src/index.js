import App from './App'
//TODO import normalize
import 'normalize-scss/sass/_normalize.scss'
import './sass/main.sass'

const app = new App('Hello, world!')
console.log(`This is App ${app.toString()}`)