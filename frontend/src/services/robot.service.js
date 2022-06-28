import {command} from './command.script.js'; 

export async function doMovement(robotId) {
    try{
        const response = await fetch(`/robots/`+robotId, {
            method: 'POST',
            headers: {'Content-Type': 'text/plain'},
            body: command
          })
        return await response.json();
    }catch(error) {
        return [];
    }
}
