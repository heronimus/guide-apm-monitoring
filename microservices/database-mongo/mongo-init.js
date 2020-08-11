db.createUser(
  {
      user: "userservices",
      pwd: "users3cr3t",
      roles: [
          {
              role: "readWrite",
              db: "userservices"
          }
      ]
  }
);
