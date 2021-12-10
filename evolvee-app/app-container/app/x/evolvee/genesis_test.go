package planet_test

import (
	"testing"

	keepertest "github.com/hello/planet/testutil/keeper"
	"github.com/hello/planet/x/planet"
	"github.com/hello/planet/x/planet/types"
	"github.com/stretchr/testify/require"
)

func TestGenesis(t *testing.T) {
	genesisState := types.GenesisState{
		// this line is used by starport scaffolding # genesis/test/state
	}

	k, ctx := keepertest.PlanetKeeper(t)
	planet.InitGenesis(ctx, *k, genesisState)
	got := planet.ExportGenesis(ctx, *k)
	require.NotNil(t, got)

	// this line is used by starport scaffolding # genesis/test/assert
}
