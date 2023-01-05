export interface Token {
  exp: number;
  iat: number;
  sub: string;
  authorities: Authorities[];
}

export interface Authorities {
  authority: string;
}
