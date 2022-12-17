package tn.vapex.developmental.fakers.files;


import tn.vapex.core.fetcher.FetchedBean;
import tn.vapex.core.fetcher.UseFetchedBeans;
import tn.vapex.developmental.fakers.factories.FakerFactory;
import tn.vapex.domain.storage.CustomFile;
import tn.vapex.domain.storage.CustomFileRepository;
import tn.vapex.domain.storage.enums.FileType;
import tn.vapex.domain.storage.enums.FileUrlType;

import java.util.*;

@UseFetchedBeans
public class FakeFileFetcher {

    private static final String BASE_DIR = "/api/uploads/fakes/";
    private static final Map<FileType, String[]> files = new EnumMap<>(FileType.class);
    @FetchedBean
    private static CustomFileRepository fileRepository;

    private static FakeFileFetcher instance;

    private FakeFileFetcher() {
    }

    public static FakeFileFetcher getInstance() {
        if (Objects.nonNull(instance)) return instance;
        initFakeFiles();
        return new FakeFileFetcher();
    }

    private static void initFakeFiles() {
        files.put(FileType.DELIVERY_MAN, new String[]{"user-1.jpg", "user-2.jpg", "user-3.jpg"});
        files.put(FileType.PRODUCT, new String[]{"liquide-1.jpg", "liquide-2.jpg", "liquide-3.jpg", "liquide-4.jpg", "liquide-5.jpg", "liquide-6.jpg",});
        files.put(FileType.ANY, new String[]{"file.png"});
    }

    private String getRandomFilenameByFileType(FileType fileType) {
        String[] fileNames = files.get(fileType);
        if (Objects.isNull(fileNames)) throw new UnsupportedOperationException();
        int fileIndex = FakerFactory.getInstance().bufferedFaker().random().nextInt(fileNames.length);
        return BASE_DIR + fileNames[fileIndex];
    }

    public CustomFile getFakeFile(FileType type) {
        CustomFile file = new CustomFile();
        String filePath = getRandomFilenameByFileType(type);
        file.setFileUrlType(FileUrlType.RELATIVE);
        file.setFileUrl(filePath);
        return fileRepository.save(file);
    }

    public List<CustomFile> getFakeFiles(FileType type, int count) {
        List<CustomFile> customFiles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            customFiles.add(getFakeFile(type));
        }
        return customFiles;
    }

}
