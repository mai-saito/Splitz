import axios from 'axios';
import { useRouter } from 'next/router'

const User = () => {
  const router = useRouter();
  const userId = router.query.userId;

  // access to springboot API via axios
  axios.get(`http:localhost:8080/users/${userId}`)
    .then((res) => {
      console.log(res.data);
    })
    .catch((e) => {
      console.error(e);
    });

  return (
    <div>User {userId}</div>
  );
}

export default User;