(
SynthDef("woosh", {
	arg freq=77.782, vol=1, attack=0.04, release=8, gate=1.0;

	var out, env, sound, noise, lpf_env, hpf_env, vib_env;

	hpf_env = EnvGen.kr(Env.perc(attackTime: 3, releaseTime: 3, curve: [1, -2]), gate: gate, levelScale: -5000.0) + 5000;
	lpf_env = EnvGen.kr(Env.perc(attackTime: 3, releaseTime: 3, curve: [1, -2]), gate: gate, levelScale: 5000.0) +
              (((SinOsc.kr(2.5) + 1) * 150) * vib_env);
	vib_env = EnvGen.kr(Env.perc(5 2 curve: [1 -2]) gate curve: [0.5, 0.5])
	noise = HPF.ar(LPF.ar((WhiteNoise.ar), lpf_env), hpf_env);

	OffsetOut.ar([0, 1], (noise * 0.5));
}
)
).add;


a=Synth("woosh", ["freq", 493.88])

a.set("gate", 0)

a.set("gate", 1)

a.set("done", Done.freeSelf)

a.free
