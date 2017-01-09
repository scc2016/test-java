package HttpNetty;

import io.netty.channel.ChannelInboundHandlerAdapter;

public class HttpChannelHandler extends ChannelInboundHandlerAdapter {

	// private HttpRequest request = null;
	// private FullHttpResponse response = null;
	//
	// @Override
	// public void channelRead(ChannelHandlerContext ctx, Object msg)
	// throws Exception {
	// if (msg instanceof HttpRequest) {
	// request = (HttpRequest) msg;
	// String uri = request.getUri();
	// String res = "";
	// try {
	// res = uri.substring(1);
	// response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
	// HttpResponseStatus.OK, Unpooled.wrappedBuffer(res
	// .getBytes("UTF-8")));
	// setJsessionId(isHasJsessionId());
	// setHeaders(response);
	// } catch (Exception e) {// 处理出错，返回错误信息
	// res = "<html><body>Server Error</body></html>";
	// response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
	// HttpResponseStatus.OK, Unpooled.wrappedBuffer(res
	// .getBytes("UTF-8")));
	// setHeaders(response);
	//
	// }
	// if (response != null)
	// ctx.write(response);
	// }
	// if (msg instanceof HttpContent) {
	// HttpContent content = (HttpContent) msg;
	// ByteBuf buf = content.content();
	// System.out.println(buf.toString(CharsetUtil.UTF_8));
	// buf.release();
	// }
	// }
	//
	// /**
	// * 设置HTTP返回头信息
	// */
	// private void setHeaders(FullHttpResponse response) {
	// response.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/html");
	// response.headers().set(HttpHeaders.Names.CONTENT_LANGUAGE,
	// response.content().readableBytes());
	// if (HttpHeaders.isKeepAlive(request)) {
	// response.headers().set(HttpHeaders.Names.CONNECTION,
	// Values.KEEP_ALIVE);
	// }
	// }
	//
	// /**
	// * 设置JSESSIONID
	// */
	// private void setJsessionId(boolean isHasJsessionId) {
	// if (!isHasJsessionId) {
	// CookieEncoder encoder = new CookieEncoder(true);
	// encoder.addCookie(HttpSession.SESSIONID,
	// HttpSessionManager.getSessionId());
	// String encodedCookie = encoder.encode();
	// response.headers().set(HttpHeaders.Names.SET_COOKIE, encodedCookie);
	// }
	// }
	//
	// /**
	// * 从cookie中获取JSESSIONID信息 判断服务器是否有客户端的JSESSIONID
	// *
	// * @author yangsong
	// * @date 2015年3月26日 下午2:08:07
	// */
	// private boolean isHasJsessionId() {
	// try {
	// String cookieStr = request.headers().get("Cookie");
	// Set<Cookie> cookies = CookieDecoder.decode(cookieStr);
	// Iterator<Cookie> it = cookies.iterator();
	//
	// while (it.hasNext()) {
	// Cookie cookie = it.next();
	// if (cookie.getName().equals(HttpSession.SESSIONID)) {
	// if (HttpSessionManager.isHasJsessionId(cookie.getValue())) {
	// return true;
	// }
	// System.out.println("JSESSIONID:" + cookie.getValue());
	//
	// }
	// }
	// } catch (Exception e1) {
	// e1.printStackTrace();
	// }
	// return false;
	// }
	//
	// @Override
	// public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	// System.out.println("server channelReadComplete..");
	// ctx.flush();// 刷新后才将数据发出到SocketChannel
	// }
	//
	// @Override
	// public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
	// throws Exception {
	// System.out.println("server exceptionCaught..");
	// ctx.close();
	// }
}