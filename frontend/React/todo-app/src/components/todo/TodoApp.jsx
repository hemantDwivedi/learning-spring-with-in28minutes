import './TodoApp.css'
import { BrowserRouter,Route, Routes} from 'react-router-dom'
import HeaderComponent from './HeaderComponent'
import LoginComponent from './LoginComponent'
import WelcomeComponent from './WelcomeComponent'
import ListTodosComponent from './ListTodosComponent'
import LogoutComponent from './LogoutComponent'
import FooterComponent from './FooterComponent'
import ErrorComponent from './ErrorComponent'

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
            <HeaderComponent />
                <Routes>
                    <Route path='/' element={<LoginComponent />} />
                    <Route path='/login' element={<LoginComponent />} />
                    <Route path='/welcome/:username' element={<WelcomeComponent />} />
                    <Route path='/todos' element={<ListTodosComponent />} />
                    <Route path='/logout' element={<LogoutComponent />} />


                    <Route path='*' element={<ErrorComponent />} />
                </Routes>
            <FooterComponent />
            </BrowserRouter>
        </div>
    )
}