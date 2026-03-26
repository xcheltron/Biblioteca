import connection from "../dababase.js";

export const addBookModel = (author, Name_Book, Sub_Title, publication_date, quantity) => {
  return new Promise((resolve, reject) => {
    connection.query(
      "CALL insertBook(?,?,?,?,?)",
      [author, Name_Book, Sub_Title, publication_date, quantity],
      (error, results) => {
        if (error) reject(error);
        else resolve(results);
      },
    );
  });
};

export const consultGeneralBookModel = (page) => {
  return new Promise((resolve, reject) => {
    connection.query("CALL consultGeneralBook(?)", [page],(err, results) =>{
      if (err) reject(err);
        else resolve(results);
    });
  });
};
