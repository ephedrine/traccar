package org.traccar.protocol;

import io.netty.buffer.ByteBuf;
import org.junit.Test;
import org.traccar.ProtocolTest;

public class Tk103FrameDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = inject(new Tk103FrameDecoder());

        verifyFrame(
                binary("283836343735353535353535353535352C445733422C3133313131372C412C353536322E30323837304E2C30313334382E3038313934452C312E3539372C3232333730372C3239312E36352C2D302E31302C3429"),
                decoder.decode(null, null, binary("283836343735353535353535353535352C445733422C3133313131372C412C353536322E30323837304E2C30313334382E3038313934452C312E3539372C3232333730372C3239312E36352C2D302E31302C3429283836343735353535353535353535352C5A4332302C3133313131372C3232333730362C362C3339342C36353533352C32353529")));

        ByteBuf buf = binary("283836343535353535353535353535352C445735422C3231302C362C353939352C34373730312C352C33303A45453A43433A45373A38363A44442A2D35392A31312C34433A36303A43433A45413A42423A45452A2D36382A312C34323A41413A44453A45413A42423A30302A2D36392A312C33323A43443A42423A43333A34463A43432A2D38362A332C31303A30303A34333A42413A32323A31352A2D38382A312C3135313131372C31363337323229283836343735353535353535353535352C5A4332302C3133313131372C3232333730362C362C3339342C36353533352C32353529");

        verifyFrame(
                binary("283836343535353535353535353535352C445735422C3231302C362C353939352C34373730312C352C33303A45453A43433A45373A38363A44442A2D35392A31312C34433A36303A43433A45413A42423A45452A2D36382A312C34323A41413A44453A45413A42423A30302A2D36392A312C33323A43443A42423A43333A34463A43432A2D38362A332C31303A30303A34333A42413A32323A31352A2D38382A312C3135313131372C31363337323229"),
                decoder.decode(null, null, buf));

        verifyFrame(
                binary("283836343735353535353535353535352C5A4332302C3133313131372C3232333730362C362C3339342C36353533352C32353529"),
                decoder.decode(null, null, buf));

        verifyFrame(
                binary("283836343735353535353535353535352C445733422C3133313131372C412C353536322E30323837304E2C30313334382E3038313934452C312E3539372C3232333730372C3239312E36352C2D302E31302C3429"),
                decoder.decode(null, null, binary("676172626167652540232A5E242D2B3C3E3F2429292924242D2D283836343735353535353535353535352C445733422C3133313131372C412C353536322E30323837304E2C30313334382E3038313934452C312E3539372C3232333730372C3239312E36352C2D302E31302C3429283836343735353535353535353535352C5A4332302C3133313131372C3232333730362C362C3339342C36353533352C32353529")));

        verifyNull(decoder.decode(null, null, binary("67")));

        verifyNull(decoder.decode(null, null, binary("676172626167652540232a5e242d2b3c3e3f24")));

        verifyFrame(
                binary("2838363437353535353535352C5A4330332C3139313131372C3233343432312C24294E6F746963653A0D0A446576696365732073657269616C206E756D6265723A200D0A3538303535353535353535292E0D0A536F6674776172652076657273696F6E3A0D0A56322E3030302C323031362F30382F32332031313A3137292429"),
                decoder.decode(null, null, binary("610D0A676172626167652540232A5E242D2B3C3E3F2429292924242D2D2838363437353535353535352C5A4330332C3139313131372C3233343432312C24294E6F746963653A0D0A446576696365732073657269616C206E756D6265723A200D0A3538303535353535353535292E0D0A536F6674776172652076657273696F6E3A0D0A56322E3030302C323031362F30382F32332031313A3137292429283836343735353535353535353535352C5A4332302C3133313131372C3232333730362C362C3339342C36353533352C32353529")));

        verifyNull(decoder.decode(null, null, binary("610D0A676172626167652540232A5E242D2B3C3E3F2429292924242D2D2838363437353535353535352C5A4330332C3139313131372C3233343432312C24294E6F746963653A0D0A446576696365732073657269616C206E756D6265723A200D0A3538303535353535353535292E0D0A536F6674776172652076657273696F6E3A0D0A56322E3030302C323031362F30382F32332031313A31372929283836343735353535353535353535352C5A4332302C3133313131372C3232333730362C362C3339342C36353533352C32353529")));

    }

}
