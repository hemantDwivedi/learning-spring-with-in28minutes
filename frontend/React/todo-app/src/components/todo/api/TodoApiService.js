import axios from "axios"

const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
)

export const retrieveAllTodosForUserApi
    = (username) => apiClient.get(`/users/${username}/todos`)

export const retrieveTodosForUserApi
    = (username, id) => apiClient.get(`/users/${username}/todos/${id}`)

export const deleteTodoApi
    = (username, id) => apiClient.delete(`/users/${username}/todos/${id}`)