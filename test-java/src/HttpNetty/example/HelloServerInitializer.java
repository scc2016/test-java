package HttpNetty.example;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		// // ��("\n")Ϊ��β�ָ�� ������
		// pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192,
		// Delimiters.lineDelimiter()));
		//
		// // �ַ���� �� ����
		// pipeline.addLast("decoder", new StringDecoder());
		// pipeline.addLast("encoder", new StringEncoder());

		pipeline.addLast(new HttpResponseEncoder());
		pipeline.addLast(new HttpRequestDecoder());
		// �Լ����߼�Handler
		pipeline.addLast("handler", new HelloServerHandler());
	}
}