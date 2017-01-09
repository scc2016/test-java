package HttpNetty.example;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class HelloServerHandler extends SimpleChannelInboundHandler<String> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg)
			throws Exception {
		// �յ���Ϣֱ�Ӵ�ӡ���
		System.out.println(ctx.channel().remoteAddress() + " Say : " + msg);

		// ���ؿͻ�����Ϣ - ���Ѿ����յ��������Ϣ
		ctx.writeAndFlush("Received your message !\n");
	}

	/*
	 * 
	 * ���� channelActive ���� ��channel�����õ�ʱ�򴥷� (�ڽ������ӵ�ʱ��)
	 * 
	 * channelActive �� channelInActive �ں���������н����������Ȳ�����ϸ������
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		System.out.println("RamoteAddress : " + ctx.channel().remoteAddress()
				+ " active !");

		// ctx.writeAndFlush("Welcome to "
		// + InetAddress.getLocalHost().getHostName() + " service!\n");

		HttpResponse httpResponse = new DefaultFullHttpResponse(
				HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
				Unpooled.wrappedBuffer("hello client".getBytes()));// ����httpResponse
		httpResponse.headers()
				.add(HttpHeaders.Names.CONTENT_TYPE, "text/plain");
		httpResponse.headers().add(HttpHeaders.Names.CONTENT_LENGTH, 11);

		ctx.writeAndFlush(httpResponse);// ������Ӧ��httpResponse
		super.channelActive(ctx);
	}
}