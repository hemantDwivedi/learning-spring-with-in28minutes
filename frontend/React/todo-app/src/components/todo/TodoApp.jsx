import { useState } from 'react'
import './TodoApp.css'

export default function TodoApp() {
    return (
        <div className="TodoApp">
            Todo Management Application
            <LoginComponent/>
            {/* <WelcomeComponent/> */}
        </div>
    )
}

function LoginComponent() {

    const [username, setUser] = useState('hemant')
    const [password, setPassword] = useState('12345')

    function handleUsernameChange(event){
        setUser(event.target.value)
    }
    
    
    function handlePasswordChange(event){
        console.log(event.target.value)
        setPassword(event.target.value)
    }

    return (
        <div className="Login">
            <div className="LoginForm">
                <div>
                    <label>Username</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type="button" name="login">Login</button>
                </div>
            </div>
        </div>
    )
}


function WelcomeComponent() {
    return (
        <div className="Welcome">Welcome Component</div>
    )
}