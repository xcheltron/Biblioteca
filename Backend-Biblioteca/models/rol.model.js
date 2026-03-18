import connection from "../dababase.js";

export const insertarRolModel = (nameRol) =>{
    return new Promise((reject, resolve) =>{
        connection.query("CALL insertRol(?)",[nameRol],(err, results)=>{
            if (err) reject(err)
                else resolve(results)
        })
    })
}