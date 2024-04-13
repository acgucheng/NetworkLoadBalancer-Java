export class Host {

    ip: string;
    port: string;
    health: string;

    constructor(ip: string, port: string, health:string) {
        this.ip = ip;
        this.port = port;
        this.health = health;
    }
}