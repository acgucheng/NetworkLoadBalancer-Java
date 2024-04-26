/* a balancer api request class that allows the user to select a balancer */

import axios from "axios";

export class Balancer {
    static async setBalancer(balancer: string) {
        await axios.post("http://localhost:8080/balancer", balancer, {headers: {
            'Content-Type': 'text/plain'
        }});
    }
}