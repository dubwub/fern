<?php

namespace Seed\Service;

use Seed\Core\Json\JsonSerializableType;
use Seed\Core\Json\JsonProperty;

class Organization extends JsonSerializableType
{
    /**
     * @var string $name
     */
    #[JsonProperty('name')]
    public string $name;

    /**
     * @param array{
     *   name: string,
     * } $values
     */
    public function __construct(
        array $values,
    ) {
        $this->name = $values['name'];
    }
}
