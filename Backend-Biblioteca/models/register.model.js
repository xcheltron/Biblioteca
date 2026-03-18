import connection from "../dababase.js";

export const registerModel = (nameRol, Name, phoneNumber, email, passwordHash) =>{
    return new Promise((resolve, reject) =>{
        connection.query("CALL register (?,?,?,?,?)",[nameRol,Name,phoneNumber,email,passwordHash], (err, results) =>{
            if(err) reject(err)
                else resolve(results)
        })
    })
}