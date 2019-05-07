package crk.jwt;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenrongkun on 2019/5/6.
 */
public class JWT {

	private static final String SECRET = "1234sdf2!#@$#&&^())sdfose";

	private static final String EXP = "exp";

	private static final String PAYLOAD = "payload";

	/**
	 * 将对象签名为JWT的token字符串，（指定有效时间）
	 * 
	 * @param object
	 *            the POJO object ，需要加密的对象
	 * @param maxAge
	 *            the milliseconds of life time ,单位 毫秒
	 * @return the jwt token
	 */
	public static <T> String sign(T object, long maxAge) {
		try {
			final JWTSigner signer = new JWTSigner(SECRET);
			final Map<String, Object> claims = new HashMap<>(2);
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(object);
			claims.put(PAYLOAD, jsonString);
			claims.put(EXP, System.currentTimeMillis() + maxAge);
			return signer.sign(claims);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将对象签名为JWT的token字符串，（指定1天有效）
	 * @param object 需要加密的对象
	 * @return
	 */
	public static <T> String sign1Day(T object) {
		long maxAge = 24 * 3600 * 1000L;
		return sign(object, maxAge);
	}

	/**
	 * 将对象签名为JWT的token字符串，（指定1小时有效）
	 * @param object 需要加密的对象
	 * @return
	 */
	public static <T> String sign1Hour(T object) {
		long maxAge = 1 * 3600 * 1000L;
		return sign(object, maxAge);
	}
	
	/**
	 * 将对象签名为JWT的token字符串，（指定1分钟有效）
	 * @param object 需要加密的对象
	 * @return
	 */
	public static <T> String sign1Minute(T object) {
		long maxAge =  60 * 1000L;
		return sign(object, maxAge);
	}
	
	/**
	 * 将对象签名为JWT的token字符串，（指定1秒钟有效）
	 * @param object 需要加密的对象
	 * @return
	 */
	public static <T> String sign1Second(T object) {
		long maxAge =  1 * 1000L;
		return sign(object, maxAge);
	}
	
	/**
	 * 将对象签名为JWT的token字符串，（指定5分钟有效）
	 * @param object 需要加密的对象
	 * @return
	 */
	public static <T> String sign5Minute(T object) {
		long maxAge =  5 * 60 * 1000L;
		return sign(object, maxAge);
	}

	
	public static boolean validate(String jwtToken){
		final JWTVerifier verifier = new JWTVerifier(SECRET);
		Map<String, Object> claims = null;
		try {
			claims = verifier.verify(jwtToken);
			if(claims == null || claims.isEmpty()){
				return false;
			}
			if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)){
				long exp = (Long) claims.get(EXP);
				long currentTimeMillis = System.currentTimeMillis();
				if (exp > currentTimeMillis) {
					//有效！
					return true;
				}else{
					//过期了！
					return false;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JWTVerifyException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 从jwt token签名中获取加密前的对象。<br>
	 * 注意，如果过了有效期或者解密密钥有错误，本方法会吃掉异常，返回值为null~!
	 * 
	 * @param jwt
	 *            token
	 * @return POJO object 解密后的对象或者null
	 */
	public static <T> T unsign(String jwt, Class<T> classT) {
		final JWTVerifier verifier = new JWTVerifier(SECRET);
		try {
			final Map<String, Object> claims = verifier.verify(jwt);
			if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
				long exp = (Long) claims.get(EXP);
				long currentTimeMillis = System.currentTimeMillis();
				if (exp > currentTimeMillis) {
					String json = (String) claims.get(PAYLOAD);
					ObjectMapper objectMapper = new ObjectMapper();
					return objectMapper.readValue(json, classT);
				}
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}


	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		String abc = sign("abc", 10000);
		System.out.println(abc);
		String unsign = unsign(abc, String.class);
		System.out.println(unsign);
	}
}