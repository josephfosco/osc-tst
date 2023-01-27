(
SynthDef("woosh", {
	arg freq=77.782, vol=1, attack=0.04, release=8, gate=1.0;

	var out, env, sound, noise, lpf_env;

	lpf_env = EnvGen(Env.perc(attackTime: 3, releaseTime: 3, curve: [1, -2]), gate: gate, levelScale: 5000.0);
    noise = LPF.ar((WhiteNoise.ar), lpf_env);

	// env = Env.asr(attackTime: attack, sustainLevel: sustain, releaseTime: release, curve: [-3, 1, -2]);
	// sound = LPF.ar((Mix.new([Pulse.ar(freq: freq), VarSaw.ar(freq: freq, width:0)]) * 0.3), freq: 2000);

	// out = sound * EnvGen.kr(envelope: env, gate: gate, levelScale: vol, doneAction: Done.none);
	OffsetOut.ar([0, 1], (noise * 0.3));
}
)
).add;


a=Synth("woosh", ["freq", 493.88])

a.set("gate", 0)

a.set("gate", 1)

a.set("done", Done.freeSelf)

a.free

a