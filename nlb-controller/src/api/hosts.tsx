/* A api package to CRUD hosts */

import axios from 'axios';
import { Host } from '../model/Host';

const API_URL = 'http://localhost:8080';

export const getHosts = async (): Promise<Host[]> => {
    const response = await axios.get(`${API_URL}/host`);
    return response.data;
};

export const deleteHost = async (ip: string, port: string): Promise<void> => {
    await axios.delete(`${API_URL}/host`,{
        data:{
            ip: ip,
            port: port
        }
    });
}