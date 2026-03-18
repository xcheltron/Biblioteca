import connection from "../dababase.js";

export const loginModel = (email) =>{
    return new Promise((resolve, reject) =>{
        connection.query("CALL login(?)",[email], (err, results) =>{
            if(err) reject (err);
                else resolve(results)
        })
    })
}