import { createContext, useContext, useState } from "react";

export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)


export default function AuthProvider({children}){

    const [isAuthenticated, setAuthenticated] = useState(false)

    function login(username, password){
        if (username === 'hemant' && password === '12345') {
            setAuthenticated(true)
            return true
        }
        else {
            setAuthenticated(false)
            return false
        }
    }

    function logout(){
        setAuthenticated(false)
    }

    return (
        <AuthContext.Provider value={{isAuthenticated, setAuthenticated, login}}>
            {children}
        </AuthContext.Provider>
    )
}
