import axios from 'axios';

export default {
    list() {
        return axios.get('/potholes');
    },
    create(pothole) {
        return axios.post('/report', pothole);
    },

    update(pothole) {
        return axios.put(`/update/${pothole.id}`, pothole);
    },

    delete(id) {
        return axios.delete(`/delete/${id}`);
    },

   
    listCoords() {
        return axios.get('/coords');
    }
}