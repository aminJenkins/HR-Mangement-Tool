export interface Token {
  exp: number;
  iat: number;
  sub: string;
  authorities: Authority[];
}

export interface Authority {
  authority: string;
}
