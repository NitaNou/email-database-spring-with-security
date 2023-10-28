import axios from "axios";

export default {
    getAllProspects() {
        return axios.get("http://localhost:9000/prospects")
    }
}