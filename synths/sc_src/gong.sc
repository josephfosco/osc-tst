(
SynthDef("gong", {
	arg freq=73.416, vol=1, attack=0.04, release=8, gate=1.0;

	var gong, gong_sound, env, freq_env, vib_env;

	env = EnvGen.kr(Env.perc(attackTime: 0.04, releaseTime: 8, curve: [-3, -2]), gate: gate);
	vib_env = EnvGen.kr(Env.perc(attackTime: 3, releaseTime: 3, curve: [1 -2]), gate: gate,
	          levelScale: 0.5);
	freq_env = EnvGen.kr(Env.perc(attackTime: 1.5, releaseTime: 6, curve: [2, 2]), gate: gate);

	gong_sound = LPF.ar(((LFTri.ar(freq: freq) * (LFTri.ar(freq: (freq* 1.5)))) +
		                  SinOsc.ar(freq: freq)),
	                   freq: 1400);
	gong = gong_sound;

	OffsetOut.ar([0, 1], (gong * vol));
}
)
).add;


a=Synth("gong")

a.set("gate", 0)

a.set("gate", 1)

a.set("done", Done.freeSelf)

a.free
