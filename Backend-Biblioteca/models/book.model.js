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
