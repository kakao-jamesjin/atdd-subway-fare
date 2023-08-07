package nextstep.subway.applicaion.dto;

import nextstep.subway.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

public class LineResponse {
    private Long id;
    private String name;
    private String color;
    private int extraCharge;
    private List<StationResponse> stations;

    public static LineResponse of(Line line) {
        List<StationResponse> stations = line.getStations().stream()
                .map(StationResponse::of)
                .collect(Collectors.toList());
        return new LineResponse(line.getId(), line.getName(), line.getColor(), line.getExtraCharge(), stations);
    }

    public LineResponse(Long id, String name, String color, int extraCharge, List<StationResponse> stations) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.extraCharge = extraCharge;
        this.stations = stations;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getExtraCharge() {
        return extraCharge;
    }

    public List<StationResponse> getStations() {
        return stations;
    }
}

