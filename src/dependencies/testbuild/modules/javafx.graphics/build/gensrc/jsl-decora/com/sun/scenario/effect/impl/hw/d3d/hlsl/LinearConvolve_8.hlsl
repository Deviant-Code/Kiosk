sampler2D img : register(s0);
float count : register(c0);
float4 offset : register(c1);
float4 weights[2] : register(c2);
void main(in float2 pos0 : TEXCOORD0,
in float2 pos1 : TEXCOORD1,
in float2 pixcoord : VPOS,
in float4 jsl_vertexColor : COLOR0,
out float4 color : COLOR0) {
int i;
float4 tmp = float4(0.0, 0.0, 0.0, 0.0);
float2 loc = pos0 + offset.zw;
{
tmp += weights[0].x * tex2D(img, loc);
loc += offset.xy;
tmp += weights[0].y * tex2D(img, loc);
loc += offset.xy;
tmp += weights[0].z * tex2D(img, loc);
loc += offset.xy;
tmp += weights[0].w * tex2D(img, loc);
loc += offset.xy;
}
{
tmp += weights[1].x * tex2D(img, loc);
loc += offset.xy;
tmp += weights[1].y * tex2D(img, loc);
loc += offset.xy;
tmp += weights[1].z * tex2D(img, loc);
loc += offset.xy;
tmp += weights[1].w * tex2D(img, loc);
loc += offset.xy;
}
color = tmp;
}
