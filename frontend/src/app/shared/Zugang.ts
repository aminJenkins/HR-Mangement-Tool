export class Zugang{
  username: string;
  password : string;
  authority: string;


  constructor(username: string, password: string, authority: string) {
    this.username = username;
    this.password = password;
    this.authority = authority;
  }
}
