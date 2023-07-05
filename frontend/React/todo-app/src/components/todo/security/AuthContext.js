import { createContext, useContext, useState } from "react";
import { executeBasicAuthenticationService } from "../api/TodoApiService";

export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)


export default function AuthProvider({ children }) {

    const [isAuthenticated, setAuthenticated] = useState(false)

    const [username, setUsername] = useState(null)

    const [token, setToken] = useState(null)

    async function login(username, password) {

        const baToken = 'Basic ' + window.btoa(username + ":" + password)

        try {

            const response = await executeBasicAuthenticationService(baToken)

            if (response.status == 200) {
                setAuthenticated(true)
                setUsername(username)
                setToken(baToken)
                return true
            }
            else {
                logout()
                return false
            }
        } catch (error) {
            logout()
            return false
        }
    }

    function logout() {
        setAuthenticated(false)
        setUsername(null)
        setToken(null)
    }

    return (
        <AuthContext.Provider value={{ isAuthenticated, setAuthenticated, login, username, token }}>
            {children}
        </AuthContext.Provider>
    )
}
